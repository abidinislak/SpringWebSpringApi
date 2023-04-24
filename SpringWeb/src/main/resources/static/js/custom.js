$(document).ready(function() {


var table=$("#tableUsers").DataTable({



	ajax: "/userList",
			"sAjaxDataProp": "",
			order: [[ 0, "asc" ]],
			columns: [
                { data: "id"},
		      { data: "name" },
		      { data: "description" },
		      { data: "date" },
		      {
                  data: null,
                  render: function (data, type, row) {
                                          let val = '';
                                          val += `<a onclick="test(${row.id})" class="btn btn-primary m-2"><i class="fas fa-drafting-compass"></i>  Delete </a>`;

                    return val;
                  }
              }


			]


});



});