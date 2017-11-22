/**
 * Created by 许栋 on 2017/9/27.
 */

$(document).ready(() => {
    loadStudio();
    loadSeat();
    loadUserMessage();
    $('#userAccount').val(sessionStorage.getItem('account'))
    $("#studio").click((ev) => {

        $(".nav2_1").slideToggle("slow");

    });
    $("#seat").click(() => {

        $(".nav2_2").slideToggle("slow");
    });
    $('#user').click(()=>{
        $('.nav2_3').slideToggle("slow");
        $('.player').css('display','none');
        $('.studio').css('display','none');
        $('.seat').css('display','none');
        $('.account').css('display','block');
        loadAccount();
        $('.nav2_3').slideToggle("slow");

    });
    $('.logout').click(()=>{
        window.location.href='./index.jsp';
    })
    $('#updateSeat').click(()=>{
        alert('修改成功');
    })
    $('#deleteStudio').click(()=>{
        alert('删除成功');
    })
});
const loadUserMessage=()=>{
    const userMessage=getUsermessage();

    const head=$('<a href="#" id="head"></a>');
    $('#header').append(head);
    const img=$('<img src='+userMessage.head+' data-toggle="modal" data-target="#updateHead" class="img-circle headImage">');
    $('#head').append(img);
    const name=$('<p class="name">'+userMessage.name+'</p>');
    $('#header').append(name);
    $('#updateHeadBtn').click(updateHead.bind(this,userMessage.id));
}

const loadAccount=()=>{
    $('.accountItem').remove();
    const account=getAccount();
    for(let i in account){
        let divNode=$('<div class="accountItem" style="width: 90%"></div>');
        divNode.attr('id',account[i].id)
        $('.account').append(divNode);
        let headNode=$('<img src="../image/head.jpg" class="accounthead img-circle">');
        let idNode=$('<span>员工编号：'+account[i].id+'</span>');
        let nameNode=$('<span>  姓名：'+account[i].name+'</span>');
        let sexNode=$('<span>  性别：'+account[i].sex+'</span>');
        let typeNode=$('<span>  员工类型：'+account[i].type+'</span>');
        let btnDelete=$('<button class="btn btn-info accountbtn" >删除用户</button>');
        btnDelete.click(()=>{
            alert('删除成功');
        });
        let btnUpdate=$('<button class="btn btn-info accountbtn" data-toggle="modal" data-target="#updateAccount">修改用户</button>');

        $('#'+account[i].id).append(headNode,idNode,nameNode,sexNode,typeNode,btnDelete,btnUpdate,'<br>');

    }

    const addAccount=$('<a href="#"><li id="add" data-toggle="modal" data-target="#addAccount">增加用户</li></a>');
    $('#add').remove();
    $('.nav2_3').append(addAccount);
}

const loadSeat=()=>{
    const Studios = getStudio();
    for (let i in Studios) {
        let liNode1 = $('<li id=' + Studios[i].id + '2' + '></li>');
        $('.nav2_2').append(liNode1);
        let aNode1 = $('<a href="#" class="st">' + Studios[i].text + '</a>');
        $('#' + Studios[i].id + '2').append(aNode1)
        $('#' + Studios[i].id + '2').click(loadSeats2.bind(this,Studios[i].id))
    }
}

const loadStudio = () => {
    $('').remove();
    const Studios = getStudio();
    for (let i in Studios) {
        let liNode1 = $('<li id=' + Studios[i].id + '1' + '></li>');
        $('.nav2_1').append(liNode1);
        let aNode1 = $('<a href="#" class="st">' + Studios[i].text + '</a>');
        $('#' + Studios[i].id+'1').append(aNode1)
        $('#' + Studios[i].id+'1').click(loadSeats1.bind(this,Studios[i].id))
    }
    let addStudio=$('<a href="#"><li id="addStudio" data-toggle="modal" data-target="#addStudio1">增加演出厅</li></a>')
    $('.nav2_1').append(addStudio);
}

const loadSeats2=(studioId)=>{
    $('.seatTag').empty();
    $('.studio').css('display','none');
    $('.account').css('display','none');
    $('.player').css('display','none');
    $('.seat').css('display','block');
    $('.seatBtn').remove();
    $('.tem').remove();
    const seats = getSeats(studioId);
    for (let i = 0; i < seats[seats.length - 1].rows; i++) {
        for (let j = 0; j < seats.length; j++) {
            if (seats[j].rows == i) {
                let btnNode = document.createElement('button');
                btnNode.className = 'seatBtn';
                btnNode.id='s'+seats[j].seatid;
                btnNode.setAttribute('data-rows',seats[j].rows);
                btnNode.setAttribute('data-cols',seats[j].cols);
                btnNode.setAttribute('data-flag','y');
                btnNode.addEventListener('click',function (e) {
                    let flag=$(this).attr('data-flag');
                    if(flag=='y'){
                        $(this).css('background-color','red');
                        $(this).attr('data-flag','n');
                        $('#rows').text($(this).attr('data-rows'));
                        $('#cols').text($(this).attr('data-cols'));
                    }else {
                        $(this).css('background-color','white');
                        $(this).attr('data-flag','y');
                        $('#rows').text('');
                        $('#cols').text('');
                    }
                },false);
                $('.seatsRoom').append(btnNode);
            }
        }
        $('.seatsRoom').append('<br class="tem">');
    }

    const studioData=getStudioMessage(studioId);
    $('.seatTag').append($('<p id="st__name">'+studioData.text+'</p>'))
    $('.seatTag').append($('<p>行：<span id="rows"></span>&emsp;&emsp;&emsp;列：<span id="cols"></span></p>'))
    $('.seatTag').append($('<p>状态：'+studioData.status+'</p>'))
    $('.seatTag').append($('<button id="updateSeat" class="btn btn-info btnus ">\n' +
        '                        确认修改\n' +
        '                    </button>'))
    $('.seatTag').append($('<span>可用:</span>'))
    $('.seatTag').append($('<button class="seatgood"></button>'));
    $('.seatTag').append($('<span>&nbsp;故障：</span>'))
    $('.seatTag').append($('<button class="seatbad"></button>'));
}
const loadSeats1 = (studioId) => {
    $('.selectAreat').empty();
    $('.studio').css('display','block');
    $('.account').css('display','none');
    $('.seat').css('display','none');
    $('.seatBtn').remove();
    $('.tem').remove();
    const seats = getSeats(studioId);
    for (let i = 0; i < seats[seats.length - 1].rows; i++) {
        for (let j = 0; j < seats.length; j++) {
            if (seats[j].rows == i) {
                let btnNode = document.createElement('button');
                btnNode.className = 'seatBtn';
                $('.seatsRoom').append(btnNode);

            }
        }
        $('.seatsRoom').append('<br class="tem">');
    }
    const studioData=getStudioMessage(studioId)
    $('.selectAreat').append($('<p id="st_name">'+studioData.text+'</p>'))
    $('.selectAreat').append($('<p>行：'+studioData.rows+'&emsp;&emsp;&emsp;列：'+studioData.cols+'</p>'))
    $('.selectAreat').append($('<p>状态：'+studioData.status+'</p>'))
    $('.selectAreat').append($('<button id="updateStudio" class="btn btn-info btnus" data-toggle="modal"\n' +
        '                            data-target="#updateStudio1">修改演出厅\n' +
        '                    </button>'))
}
const updateHead=(userId)=>{
    console.log($('#headInput')[0]);
    console.log(userId);
    const head=new FormData($('#headInput')[0]);
    console.log(head);
    $.ajax({
        url:'/aasdasd',
        type:'post',
        data:head,
        success:function () {
            alert('success');
        },
        error:function () {
            alert('fail')
        }

    })


}




const getAccount=()=>{
    return [
        {
            id: '1000001',
            name:'栋哥',
            sex:'男',
            type:'admin',
            head:''
        },
        {
            id: '1000002',
            name: '旺哥',
            sex:'男',
            type:'common',
            head:''
        },
        {
            id: '1000003',
            name: '乐哥',
            sex:'男',
            type:'common',
            head:''
        },
        {
            id: '1000004',
            name: '男神',
            sex:'男',
            type:'common',
            head:''
        }
    ]
}

const getSeats = (studioId) => {
    const seats = new Array();
    let nextid = 1;
    const rows=8;
    const cols=10;
    for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            seats.push({
                seatid: nextid++,
                rows: i+1,
                cols: j+1,

            })
        }
    }
    return seats;
}


const getStudio = () => {
    return [
        {
            id: 't1',
            text: '一号演出厅',
        },
        {
            id: 't2',
            text: '二号演出厅',
        },
        {
            id: 't3',
            text: '三号演出厅',
        }
    ]
}

const getStudioMessage=(studioId)=>{
    return{
        id:'t1',
        text:'一号演出厅',
        cols:10,
        rows:8,
        status:'可用'
    }
}
const getUsermessage=()=>{
    return {
        id: '1000004',
        name: '男神',
        sex:'男',
        type:'common',
        head:'../image/head.jpg'
    }
}