document.addEventListener("DOMContentLoaded", function(event) {

   document.getElementById("submit_button").addEventListener("click", function(event) {
      resetFields();
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
                    document.getElementById("google_card").style.opacity = 1;
                    document.getElementById("google_card").style.display = "block";
                    appendResultData("google_results", data);
                    googleSum += data.resultCount;
                })
            );
        }
        if(yahooChecked){
            data.searchEngine = "yahoo";
            fetches.push(
                postData(data).then(data => {
                    document.getElementById("yahoo_card").style.opacity = 1;
                    document.getElementById("yahoo_card").style.display = "block";
                    appendResultData("yahoo_results", data);
                    yahooSum += data.resultCount;
                })
            );
        }
      }
      Promise.all(fetches).then(function() {
         appendResultData("google_summary", {resultCount: googleSum});
         appendResultData("yahoo_summary", {resultCount: yahooSum});
      });
   })

   function appendResultData(elem, data) {
       let formatter = Intl.NumberFormat();
       let containSearchQuery = data.query == undefined ? false : true;
       if(containSearchQuery){
        document.getElementById(elem).innerHTML += data.resultCount.toLocaleString('en-US') + " results for word " + data.query + "<br />";
       } else {
        document.getElementById(elem).innerHTML += "Summary: " + data.resultCount.toLocaleString('en-US') + "<br />";
       }

   }

   function resetFields() {
       let googleCard = document.getElementById("google_card");
       googleCard.style.opacity = 0;
       googleCard.style.display = "none";

       let yahooCard = document.getElementById("yahoo_card");
       yahooCard.style.opacity = 0;
       yahooCard.style.display = "none";

       let googleSummary = document.getElementById("google_summary");
       googleSummary.innerHTML = "";
       let googleResults = document.getElementById("google_results");
       googleResults.innerHTML = "";
       let yahooResults = document.getElementById("yahoo_results");
       yahooResults.innerHTML = "";
       let yahooSummary = document.getElementById("yahoo_summary");
       yahooSummary.innerHTML = "";
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
   }
})