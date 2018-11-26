	var helpers =
	{
	    buildDropdown: function(result, dropdown, emptyMessage)
	    {
	        dropdown.html('');
	        dropdown.append('<option value="">' + emptyMessage + '</option>');
	        if(result != '')
	        {
	            $.each(result, function(k, v) {
	                dropdown.append('<option value="' + v.id + '">' + v.value + '</option>');
	            });
	        }
	    },
	    ajaxhelpers:function(data,url,httpmethod){
			$.ajax({
				type : httpmethod,
				contentType : "application/json",
				url : url,
				data : JSON.stringify(data),
				dataType : 'json',
				timeout : 100000,
				//crossDomain: true,
				//headers: {"X-My-Custom-Header": "some value"},
				//async: false,
		        crossDomain: true,
				success : function(data) {
					var trHTML = '<tbody><tr> <th>Name </th> <td>'+data.name+'</td> </tr> <tr> <th>Minor or Major</th> <td>'+data.minmajor+'</td> </tr> <tr> <th>Age In Year</th> <td>'+data.ageinyear+'</td> </tr> <tr> <th>Age In Months</th> <td>'+data.ageinmonths+'</td> </tr> <tr> <th>Age In Weeks</th> <td>'+data.ageinweeks+'</td> </tr> <tr> <th>Age In Days</th> <td>'+data.ageindays+'</td> </tr> <tr> <th>Age In Hours</th> <td>'+data.ageinhours+'</td> </tr> <tr> <th>Age In Minute</th> <td>'+data.ageinminutes+'</td> </tr> <tr> <th>Age In Seconds</th> <td>'+data.ageinseconds+'</td> </tr> </tbody>';
					 $('#records_table').append(trHTML);
				},
				error : function(e) {
					console.log("ERROR: ", e);
				//	display(e);
				},
				done : function(e) {
					console.log("DONE");
				}
			});
			
		}
	}