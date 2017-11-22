/**
 * Created by 许栋 on 2017/9/27.
 */
$(document).ready(() => {
    loadStudio();
    loadSeat();
    $("#studio").click((ev) => {

        $(".nav2_1").slideToggle("slow");

    });
    $("#seat").click(() => {

        $(".nav2_2").slideToggle("slow");
    });
    $('#play').click(()=>{
        $('.studio').css('display','none');
        $('.account').css('display','none');
        $('.seat').css('display','none');
        $('.player').css('display','block');
        loadpalyer();
    })
    $('#user').click(()=>{
        $('.player').css('display','none');
        $('.studio').css('display','none');
        $('.seat').css('display','none');
        $('.account').css('display','block');
        loadAccount();
    });
    $('.logout').click(()=>{
        window.location.href='./login.html';
    })
    $('#updateSeat').click(()=>{
        alert('修改成功');
    })
    $('#deleteStudio').click(()=>{
        alert('删除成功');
    })
});

const loadpalyer=()=>{
    $('.playerItem').remove();
    const player=getPlayer();
    for(let i in player){
        let divNode=$('<div class="playerItem"></div>');
        divNode.attr('id',player[i].id)
        $('.player').append(divNode);

        let headNode=$('<img src="../image/电影.jpg" class="playerhead ">');
        let idNode=$('<span>剧目编号：'+player[i].id+'</span>');
        let nameNode=$('<span>  剧目名名：'+player[i].name+'</span>');
        let timeNode=$('<span>  播放时长：'+player[i].time+'</span>');
        let typeNode=$('<span>  剧目类型：'+player[i].type+'</span>');
        let btnDelete=$('<button class="btn btn-info playerbtn">删除剧目</button>');
        btnDelete.click(()=>{
            alert('删除成功');
        });
        let btnUpdate=$('<button class="btn btn-info playerbtn" data-toggle="modal" data-target="#updatePlayer">修改剧目</button>');
        $('#'+player[i].id).append(headNode,idNode,nameNode,timeNode,typeNode,btnDelete,btnUpdate,'<br>');
    }

}
const loadAccount=()=>{
    $('.accountItem').remove();
    const account=getAccount();
    for(let i in account){
        let divNode=$('<div class="accountItem"></div>');
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
}
const loadSeat=()=>{
    const Studios = getStudio();
    for (let i in Studios) {
        let liNode1 = $('<li id=' + Studios[i].id + '2' + '></li>');
        $('.nav2_2').append(liNode1);
        let aNode1 = $('<a href="#" class="st">' + Studios[i].text + '</a>');
        $('#' + Studios[i].id + '2').append(aNode1)
        $('#' + Studios[i].id + '2').click(loadSeats2)
    }
}
const loadStudio = () => {
    $('').remove();
    const Studios = getStudio();
    for (let i in Studios) {
        let liNode1 = $('<li id=' + Studios[i].id + '1' + '></li>');
        $('.nav2_1').append(liNode1);
        let aNode1 = $('<a href="#" class="st">' + Studios[i].text + '</a>');
        $('#' + Studios[i].id + '1').append(aNode1)
        $('#' + Studios[i].id + '1').click(loadSeats1)
    }
}
const loadSeats2=()=>{

    $('.studio').css('display','none');
    $('.account').css('display','none');
    $('.player').css('display','none');
    $('.seat').css('display','block');
    $('.seatBtn').remove();
    $('.tem').remove();
    const seats = getSeats(8, 10);
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
}
const loadSeats1 = () => {
    // $('#st_name').text(e);
    $('.studio').css('display','block');
    $('.account').css('display','none');
    $('.player').css('display','none');
    $('.seat').css('display','none');
    $('.seatBtn').remove();
    $('.tem').remove();
    const seats = getSeats(8, 10);
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
}

const getPlayer=()=>{
    return [
        {
            id: '2000001',
            name:'剧目一',
            time:'120min',
            type:'悬疑片'
        },
        {
            id: '2000002',
            name: '剧目二',
            time:'130min',
            type:'动作片'
        },
        {
            id: '2000003',
            name: '剧目三',
            time:'100min',
            type:'动漫'
        },
        {
            id: '2000004',
            name: '剧目四',
            time:'108min',
            type:'喜剧'
        }
    ]
}
const getAccount=()=>{
    return [
        {
            id: '1000001',
            name:'栋哥',
            sex:'男',
            type:'admin'
        },
        {
            id: '1000002',
            name: '旺哥',
            sex:'男',
            type:'manager'
        },
        {
            id: '1000003',
            name: '乐哥',
            sex:'男',
            type:'manager'
        },
        {
            id: '1000004',
            name: '男神',
            sex:'男',
            type:'manager'
        }
    ]
}

const getSeats = (rows, cols) => {
    const seats = new Array();
    let nextid = 1;
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