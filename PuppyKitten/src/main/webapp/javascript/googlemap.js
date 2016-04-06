	$(document).ready(function(){	
		var taipei;
		var area;
		var kind;
		var select;
<<<<<<< HEAD
		
=======
		$('#datatable').DataTable();
>>>>>>> branch 'master' of https://github.com/EEIT84-PK/PuppyKitten.git
		$('.text').hide().val('');
		
		$('.click').click(function(){
			select=$(this).val();
			$('#select').text(select);
			$("#kind").val(select);
		});
		
		$('.trcolor').mouseover(function(){
			$(this).css("background-color","#afffaa").mouseout(function(){
				$(this).css("background-color","white")
			}).click(function(){
	 			$('#address').val($(this).find("td:eq(3)").text());
			});
		});
		$("#taipei").change(function() {
			$(".areaop").remove();
			if($("#taipei option:selected").val()=="新北市"){
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("板橋區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("新莊區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("土城區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("中和區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("永和區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("樹林區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("三峽區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("鶯歌區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("三重區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("蘆洲區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("五股區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("泰山區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("林口區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("淡水區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("金山區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("八里區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("萬里區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("石門區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("三芝區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("瑞芳區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("汐止區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("平溪區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("貢寮區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("雙溪區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("深坑區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("石碇區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("新店區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("坪林區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("烏來區"));
				
			}else if($("#taipei option:selected").val()=="台北市"){
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("大安區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("中山區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("文山區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("信義區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("中正區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("大同區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("松山區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("萬華區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("士林區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("北投區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("內湖區"));
				$('#taipeiarea').append($("<option></option>").attr("class","areaop").text("南港區"));
			}
			if($("#taipei option:selected").val()=="1"){
				$('#add').val('');
			}else{
				taipei =$("#taipei option:selected").val();
				$("#city").val(taipei);
			}
			});	
		$('#taipeiarea').change(function(){		
			area =$("#taipeiarea option:selected").val();
			$("#area").val(area);
		});
		
		
	
		
		
	});
	
	function initMap() {
		  var directionsService = new google.maps.DirectionsService;
		  var directionsDisplay = new google.maps.DirectionsRenderer;
		  var map = new google.maps.Map(document.getElementById('map'), {
			  zoom: 19,
			  center: {lat: 25.033818, lng: 121.543592}
		  });
		  directionsDisplay.setMap(map);

		  var onChangeHandler = function() {
		    calculateAndDisplayRoute(directionsService, directionsDisplay);
		  };
		  document.getElementById('submit').addEventListener('click', onChangeHandler);
		}

		function calculateAndDisplayRoute(directionsService, directionsDisplay) {
		  directionsService.route({
		    origin:'106台北市大安區復興南路一段390號',
		    destination: document.getElementById('address').value,
		    waypoints: [],
		    // 路線最佳化
		    optimizeWaypoints: true,
		    travelMode: google.maps.TravelMode.DRIVING
		  }, function(response, status) {
		    if (status === google.maps.DirectionsStatus.OK) {
		      directionsDisplay.setDirections(response);
		      if (status == google.maps.DirectionsStatus.OK) {
		          var route = response.routes[0];
		          // 取得距離
		          var Distance=route.legs[0].distance.text;
		          // 取得路徑大約時間
		          var Duration=route.legs[0].duration.text;
		          document.getElementById('msg').innerHTML = '離目的地距離為'+Distance + ', 估計時間為' + Duration ;
		      }
		    } else {
		      window.alert('路線規劃請求失敗 , 原因是:' + status);
		    }
		  });
		}
