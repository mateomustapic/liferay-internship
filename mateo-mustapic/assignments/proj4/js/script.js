function search() {
  var input;
  var filter;
  var table;
  var tr;
  var td;
  var i;
 
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    td2 = tr[i].getElementsByTagName("td")[1];
    td3 = tr[i].getElementsByTagName("td")[2];
    td4 = tr[i].getElementsByTagName("td")[3];

    if (td||td2||td3||td4) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } 
      else if (td2.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      }
      else if (td3.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      }
      else if (td4.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      }
      else {
        tr[i].style.display = "none";
      }
    }
  }
}
