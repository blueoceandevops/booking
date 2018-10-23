//语言设置
var initialLocaleCode = 'zh-cn';

$('#calendar').fullCalendar({

    //样式
    // themeSystem: 'bootstrap4',

    // views: {
    //     month: { // name of view
    //         titleFormat: 'YYYY年MM月DD日'
    //         // other view-specific options here
    //     }
    // },


    //头部样式
    header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,agendaWeek,agendaDay,listWeek'
    },
    defaultDate: '2018-04-26',
    navLinks: true, // can click day/week names to navigate views
    // weekNumbers: true,
    weekNumbersWithinDays: true,
    weekNumberCalculation: 'ISO',
    editable: true,
    eventLimit: true, // allow "more" link when too many events


    events: [
        {
            title: '赵六',
            start: '2018-04-01T16:00:00',
            end: '2018-04-01T17:00:00'
        },
        {
            title: '孙三',
            start: '2018-04-01T18:00:00',
            end: '2018-04-01T19:00:00'
        },
        {
            title: '赵六',
            start: '2018-04-01T13:00:00',
            end: '2018-04-01T14:00:00'
        },
        {
            title: '李七',
            start: '2018-04-01T12:00:00',
            end: '2018-04-01T13:00:00'
        },
        {
            title: '周十',
            start: '2018-04-01T11:00:00',
            end: '2018-04-01T12:00:00'
        },
        {
            id: 3,
            title: '张三',
            start: '2018-04-04T16:00:00',
            end: '2018-04-04T17:00:00',
            color: 'green'
        },

        {
            id: 3,
            title: '张三',
            start: '2018-04-11T16:00:00',
            end: '2018-04-11T17:00:00',
            color: 'green'
        },
        {
            id: 3,
            title: '张三',
            start: '2018-04-18T16:00:00',
            end: '2018-04-18T17:00:00',
            color: 'green'
        },
        {
            id: 3,
            title: '张三',
            start: '2018-04-25T16:00:00',
            end: '2018-04-25T17:00:00',
            color: 'green'
        },

        {
            id: 4,
            title: '李四',
            start: '2018-04-01T17:00:00',
            end: '2018-04-01T18:00:00'
        },
        {
            id: 5,
            title: '王五',
            start: '2018-04-01T19:00:00',
            end: '2018-04-01T20:00:00'
        },
        {
            id: 6,
            title: '李四',
            start: '2018-04-26T19:00',
            end: '2018-04-26T20:00'
        },
        {
            id: 7,
            title: 'Rain',
            start: '2018-04-26T20:00',
            end: '2018-04-26T21:00',
            url: 'javascript:alert("老师棒棒哒")',
            color: 'blue'
        }
    ]
});