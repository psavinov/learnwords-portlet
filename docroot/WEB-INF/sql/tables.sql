create table LangLearn_LLSettings (
	settingsId LONG not null primary key,
	localeFrom VARCHAR(75) null,
	localeTo VARCHAR(75) null,
	wordsPerDay INTEGER,
	mode_ INTEGER,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table LangLearn_LLStat (
	statId LONG not null primary key,
	statType INTEGER,
	statString VARCHAR(75) null,
	statInt INTEGER,
	statLong LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table LangLearn_LLWord (
	wordId LONG not null primary key,
	locale VARCHAR(75) null,
	word VARCHAR(75) null,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table LangLearn_LLWordPair (
	wordPairId LONG not null primary key,
	wordFromId LONG,
	wordToId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);