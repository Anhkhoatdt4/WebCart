const labels = ['Tháng 1','Tháng 2','Tháng 3','Tháng 4','Tháng 5','Tháng 6']
const data ={
    labels: labels,
    datasets:[
        {
        label: 'Thử 1 tí',
        backgroundColor: 'red',
        borderColor: 'blue',
        data: [10,27,56,34,24,53],
        tension: 1.5,
        },
        {
            label: 'Thử 2 tí',
            backgroundColor: 'yellow',
            borderColor: 'yellow',
            data: [23, 45, 78, 69, 14, 32],
            tension: 0.4,
            },
    ],
}
const config2 ={
    type:'bar',
    data: data,
}
const barne = document.getElementById('barne');
console.log(barne)
const chart = new Chart(barne, config2)