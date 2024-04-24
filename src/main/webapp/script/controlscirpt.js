function createChart() {
			const doubleArrayInput = document.getElementById('doubleArray');
			const doubleArrayString = doubleArrayInput.value;
			// Chuyển đổi chuỗi thành mảng số
			const doubleArray = doubleArrayString.split(',').map(Number);
			doubleArray.shift();
			const doubleArrayInput1 = document.getElementById('doubleArray1');
			const doubleArrayString1 = doubleArrayInput1.value;
			// Chuyển đổi chuỗi thành mảng số
			const doubleArray1 = doubleArrayString1.split(',').map(Number);
			doubleArray1.shift();

			const labels = [ 'Thứ hai', 'Thứ ba', 'Thứ tư', 'Thứ năm',
					'Thứ sáu', 'Thứ bảy', 'Chủ nhật' ];
			const data = {
				labels : labels,
				datasets : [ {
					label : 'Tuần này',
					backgroundColor : 'blue',
					borderColor : 'blue',
					data : doubleArray,
					tension : 0.4,
				}, {
					label : 'Tuần trước',
					backgroundColor : 'red',
					borderColor : 'red',
					data : doubleArray1,
					tension : 0.4,
				}, ],
			};
			console.log('Đã tạo biểu đồ và thực hiện các xử lý tùy chỉnh.');

			console.log(doubleArray);
			const config = {
				type : 'line',
				data : data,
			};
			const canvas = document.getElementById('canvas');
			const chart = new Chart(canvas, config);

			console.log('Đã tạo biểu đồ và thực hiện các xử lý tùy chỉnh.');
		}

		function createChart1() {
			const doubleArrayInput2 = document.getElementById('doubleArray2');
			const doubleArrayString2 = doubleArrayInput2.value;
			// Chuyển đổi chuỗi thành mảng số
			const doubleArray2 = doubleArrayString2.split(',').map(Number);
			doubleArray2.shift();
			
			// Tạo một đối tượng Date đại diện cho thời gian hiện tại
			const currentDate = new Date();

			// Lấy ra tháng hiện tại (tính từ 0)
			const currentMonth = currentDate.getMonth() + 1; // Thêm 1 vì tháng tính từ 0 đến 11

			// Lấy ra năm hiện tại
			const currentYear = currentDate.getFullYear();
			
			console.log( currentMonth);
			console.log( currentYear);
			let labels=new Array();;
			if (currentMonth>=6) 
				for (let i = 0; i <= 5; i++)
				{
				labels.unshift('Tháng'+(currentMonth-i));
				console.log("cc" + currentMonth - i);
				}
			else 
				for (let i = 0; i <= 5; i++)
				{
					if (currentMonth-i>0)
					{
						labels.unshift('Tháng'+(currentMonth-i));
						console.log("cc1" + currentMonth - i);
						}
					else
						labels.unshift('Tháng'+(12+(currentMonth-i)));
						console.log("cc2" + (12-(currentMonth-i))-1);
				}
			const data = {
				labels : labels,
				datasets : [ {
					label : 'Thử 1 tí',
					backgroundColor : 'blue',
					borderColor : 'blue',
					data : doubleArray2,
					tension : 0.4,
				}/* , {
					label : 'Thử 2 tí',
					backgroundColor : 'red',
					borderColor : 'red',
					data : [ 23, 45, 78, 69, 14, 32, 87, 56, 90, 18, 42, 61 ],
					tension : 0.4,
				}, */ ],
			}
			const config2 = {
				type : 'bar',
				data : data,
			}
			const barne = document.getElementById('barne')
			const chart = new Chart(barne, config2)
		}
		window.onload = function() {
			createChart();
			createChart1();

		};