if (!document.getElementsByClassName) {
	document.getElementsByClassName = function(cl) {
		var myclass, elem, classes;
		retnode = [];
		myclass = new RegExp('\\b'+cl+'\\b');
		elem = this.getElementsByTagName('*');
		for (var i = 0, ii = elem.length; i < ii; i++) {
			classes = elem[i].className;
			if (myclass.test(classes)) retnode.push(elem[i]);
		}
	};
}

LangLearn = {
	addTranslationOnChange: function (state) {
		var list = document.getElementsByClassName("LLTransTR");
		for (var k=0;k<list.length;k++) {
			if (state) {
				list[k].style.display = "";
			} else {
				list[k].style.display = "none";
			}
		}
	}
};