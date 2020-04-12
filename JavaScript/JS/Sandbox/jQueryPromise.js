var customPromiseExample = function() {
		var customDfd = new $.Deferred();
		debugger;
		var customArray = ["Apple"];
		setTimeout(function(){ customDfd.resolve(customArray); }, 5000);
		
		return customDfd.promise()
	}

customPromiseExample().done(function(customArray){ console.log("Should appear after 5 seconds. Got from promise: " +customArray )})

console.log("When this will appear? After primse or earlier?")