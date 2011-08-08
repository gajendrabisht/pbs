$(document).ready(function() {
	
	$('#autocompletesuggestedmovies').autocomplete({
		source: function(request, response) {
			$.getJSON(
				"/pbs/imdb/testingJson",
				{movieName: request.term},
				function(movies) {
					response($.each(movies, function(index, movie) {
						//alert(movie.name);
						return {
							label: movie.name,
							value: movie.name
						};
					}));
				}
			);
			//response("hello");
			
//			$.ajax({
//				url: "/pbs/imdb/testingJson",
//				dataType: "jsonp",
//				data: {
//					movieName: request.term
//				},
//				success: function( data ) {
//					response( $.each( data, function( index, item ) {
//						alert(item.name);
//						return {
//							label: item.name,
//							value: item.name
//						};
//					}));
//				}
//			});
		}
	});
});