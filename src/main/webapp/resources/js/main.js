$(document).ready(function() {
	
	$('#autoCompleteMovies').autocomplete({
		source: function(request, response) {
			$.getJSON(
				"/pbs/imdb/autocomplete/movies",
				{movieName: request.term},
				function(movies) {
					response($.each(movies, function(index, movie) {
						alert(movie.name);
						return {
							label: movie.name,
							value: movie.name
						};
					}));
				}
			);
		}
	});
	
	$('#autoCompleteUsers').autocomplete({
		source: function(request, response) {
			$.getJSON(
				"/pbs/imdb/autocomplete/users",
				{userName: request.term},
				function(users) {
					response($.each(users, function(index, user) {
						alert(user.name + ", " + user.email + ", " + user.password + ", " + user.country);
						return {
							label: user.name,
							value: user.name
						};
					}));
				}
			);
		}
	});
	
	$('#autoCompleteUsersXmlFormat').autocomplete({
		source: function(request, response) {
			$.ajax({
				url: "/pbs/imdb/autocomplete/users",
				data: {userName: request.term},
				dataType: "xml",
				contentType: "application/xml",
				complete: function(users) {
					alert(typeof users + ", " + users.length);
				}
			});
		}
	});
	
});