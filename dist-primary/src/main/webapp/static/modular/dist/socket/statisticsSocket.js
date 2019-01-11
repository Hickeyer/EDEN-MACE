
function tradeinfo(datas) {

    data = datas["tradeCounts"];
    dataAmount = datas["tradeAmounts"];

    console.log(data);
    var dateList = data.map(function (item) {
        return item[0];
    });
    var valueList = data.map(function (item) {
        return item[1];
    });
    var dataAmountList = dataAmount.map(function (item) {
        return item[0];
    });
    var valueAmountList = dataAmount.map(function (item) {
        return item[1];
    });

    option = {

        // Make gradient line here
        visualMap: [{
            show: false,
            type: 'continuous',
            seriesIndex: 0,
            min: 0,
            max: 400
        }, {
            show: false,
            type: 'continuous',
            seriesIndex: 1,
            dimension: 0,
            min: 0,
            max: dateList.length - 1
        }],


        title: [{
            left: 'center',
            text: '实时交易订单总量'
        }, {
            top: '55%',
            left: 'center',
            text: '实时交易订单金额'
        }],
        tooltip: {
            trigger: 'axis'
        },
        xAxis: [{
            data: dateList
        }, {
            data: dataAmountList,
            gridIndex: 1
        }],
        yAxis: [{
            splitLine: {show: false}
        }, {
            splitLine: {show: false},
            gridIndex: 1
        }],
        grid: [{
            bottom: '60%'
        }, {
            top: '60%'
        }],
        series: [{
            type: 'line',
            showSymbol: false,
            data: valueList
        }, {
            type: 'line',
            showSymbol: false,
            data: valueAmountList,
            xAxisIndex: 1,
            yAxisIndex: 1
        }]
    };


    tradeChart.setOption(option);
}