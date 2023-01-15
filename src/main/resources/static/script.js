document.addEventListener("DOMContentLoaded", function(event) {

   document.getElementById("submit_button").addEventListener("click", function(event) {
      document.getElementById("google_title").style.opacity = 0;
      document.getElementById("yahoo_title").style.opacity = 0;
      document.getElementById("google_results").innerHTML = "";
      document.getElementById("yahoo_results").innerHTML = "";
      let googleChecked = document.getElementById("google_checkbox").checked;
      let yahooChecked = document.getElementById("yahoo_checkbox").checked;
      let searchQuery = document.getElementById("search_query").value;

      if (!googleChecked && !yahooChecked) {
          alert("Please select at least one option");
          return;
      }
      if (searchQuery == "") {
          alert("Please enter a search query");
          return;
      }

      let fetches = [];

      let splittedSearchQuery = searchQuery.split(" ");
      let googleSum = 0;
      let yahooSum = 0;

      for (let i = 0; i < splittedSearchQuery.length; i++) {
        let data = {
        "searchQuery": splittedSearchQuery[i],
        "searchEngine": "",
        }

        if(googleChecked){
            data.searchEngine = "google";
            fetches.push(
                postData(data).then(data => {
                    document.getElementById("google_title").style.opacity = 1;
                    appendCard("google_results", data, i);
                    googleSum += data.resultCount;
                })
            );
        }
        if(yahooChecked){
            data.searchEngine = "yahoo";
            fetches.push(
                postData(data).then(data => {
                    document.getElementById("yahoo_title").style.opacity = 1;
                    appendCard("yahoo_results", data, i);
                    yahooSum += data.resultCount;
                })
            );
        }
      }
      Promise.all(fetches).then(function() {
         appendCard("google_results", {query: "Summary", resultCount: googleSum});
         appendCard("yahoo_results", {query: "Summary", resultCount: yahooSum});
      });
   })

   function appendCard(elem, data, id) {
       let cardTitle = data.query == "Summary" ? "Summary: " : "Search query: \"" + data.query + "\"";
       let cardData = (data.query == "Summary" ? "Total count: " : "Result count: ") + data.resultCount;
       let divId = elem + id;
       document.getElementById(elem).innerHTML += "<div class='col-sm-2'><div id="+ divId +" class='card result_card'>" +
                                                       "<div class='card-body'>" +
                                                         "<h5 class='card-title'>" + cardTitle + "</h5>" +
                                                         "<h6 class='card-subtitle mb-2 text-muted'>" + cardData + "</h6>" +
                                                       "</div></div></div><div class='col-sm-1'></div><br>";
       document.getElementById(divId).style.opacity = 1;
   }

   async function postData(data) {
     const response = await fetch("\dosearch", {
       method: 'POST',
       headers: {
         'Content-Type': 'application/json'
       },
       body: JSON.stringify(data)
     });
     return response.json();
   }í
})