const labels = ['Tháng 1','Tháng 2','Tháng 3','Tháng 4','Tháng 5','Tháng 6','Tháng 7','Tháng 8','Tháng 9','Tháng 10','Tháng 11','Tháng 12']
const data ={
    labels: labels,
    datasets:[
        {
        label: 'Thử 1 tí',
        backgroundColor: 'blue',
        borderColor: 'blue',
        data: [10,27,56,34,24,53,45,78,12,35,40,60],
        tension: 0.4,
        },
        {
            label: 'Thử 2 tí',
            backgroundColor: 'red',
            borderColor: 'red',
            data: [23, 45, 78, 69, 14, 32, 87, 56, 90, 18, 42, 61],
            tension: 0.4,
            },
    ],
}
const config ={
    type:'line',
    data: data,
}
const canvas = document.getElementById('canvas');
const chart = new Chart(canvas, config)