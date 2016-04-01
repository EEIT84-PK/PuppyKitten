$(document).ready(function(){
	
	$('#inputforhide').hide();
	$('#datatable').DataTable();
	var $update =$('input[class=update]');
	var $delete =$('input[class=delete]');
	var path = "/PuppyKitten";
 	var url = path+"/map/mapActionBack.controller";
	$update.click(function(){
		var $text =$(this).parent().siblings().eq(0).text();
		var $kind =$(this).parent().siblings().eq(1).text();
		var $name =$(this).parent().siblings().children().eq(0).val();
		var $address = $(this).parent().siblings().children().eq(1).val();
		var $phone = $(this).parent().siblings().children().eq(2).val();
	 	var queryString = "&id="+$text+"&kind="+$kind+"&name="+$name
	 	+"&address="+$address+"&phone="+$phone+"&use=update&dummy="+new Date().getTime();
	 	request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
	});
	$delete.click(function(){
		$(this).parents('tr').fadeOut(1500);
		var $text =$(this).parent().siblings().eq(0).text();
	 	var queryString = "&id="+$text+"&use=delete&dummy="+new Date().getTime();
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
		
	});
	
	function insert() {
		var $kind = $('#kind').val();
		var $name = $('#name').val();
		var $phone = $('#phone').val();
		var $city = $('#city').val();
		var $area = $('#area').val();
		var $address = $('#address').val();
		var queryString = "&kind="+$kind+"&name="+$name+"&phone="+$phone+"&city="+$city+
		"&area="+$area+"&address="+$address+"&use=insert&dummy="+new Date().getTime();
		dialog.dialog( "close" );
		request = new XMLHttpRequest();
		request.onreadystatechange = doReadyStateChange;
		request.open("GET", url+"?"+queryString, true);
		request.send();
    }
 
	
	function doReadyStateChange() {
		if(request.readyState==4) {
			if(request.status==200) {
				$('#success').html(request.responseText);
			} else {
				console.log("錯誤代碼:"+request.status+", "+request.statusText);
			}
		}
	}
			//新增店家的部分
		    var dialog, form,
		 
		      // From http://www.whatwg.org/specs/web-apps/current-work/multipage/states-of-the-type-attribute.html#e-mail-state-%28type=email%29
		   
		      name = $( "#name" ),
		      email = $( "#email" ),
		      password = $( "#password" ),
		      allFields = $( [] ).add( name ).add( email ).add( password ),
		      tips = $( ".validateTips" );
		 
		    function updateTips( t ) {
		      tips
		        .text( t )
		        .addClass( "ui-state-highlight" );
		      setTimeout(function() {
		        tips.removeClass( "ui-state-highlight", 1500 );
		      }, 500 );
		    }
		 
		    function checkLength( o, n, min, max ) {
		      if ( o.val().length > max || o.val().length < min ) {
		        o.addClass( "ui-state-error" );
		        updateTips( "Length of " + n + " must be between " +
		          min + " and " + max + "." );
		        return false;
		      } else {
		        return true;
		      }
		    }
		 
		    function checkRegexp( o, regexp, n ) {
		      if ( !( regexp.test( o.val() ) ) ) {
		        o.addClass( "ui-state-error" );
		        updateTips( n );
		        return false;
		      } else {
		        return true;
		      }
		    }
		 
		    
		    dialog = $( "#dialog-form" ).dialog({
		      autoOpen: false,
		      height: 500,
		      width: 350,
		      modal: true,
		      buttons: {
		        "新增": insert,
		        "取消": function() {
		          dialog.dialog( "close" );
		        }
		      },
		      close: function() {
		        form[ 0 ].reset();
		        allFields.removeClass( "ui-state-error" );
		      }
		    });
		 
		    form = dialog.find( "form" ).on( "submit", function( event ) {
		      event.preventDefault();
		      addUser();
		    });
		 
		    $( "#create-user" ).button().on( "click", function() {
		      dialog.dialog( "open" );
		    });

});
