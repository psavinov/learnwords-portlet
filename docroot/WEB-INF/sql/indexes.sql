create index IX_2659F3CC on LangLearn_LLSettings (userId);

create index IX_660A113D on LangLearn_LLStat (userId);
create index IX_2B9F5DD on LangLearn_LLStat (userId, createDate, statType);
create index IX_C5B7101F on LangLearn_LLStat (userId, statType);

create index IX_FAA61187 on LangLearn_LLWord (locale);
create index IX_907ADD45 on LangLearn_LLWord (word, locale);

create index IX_F90A3E76 on LangLearn_LLWordPair (wordFromId);
create index IX_75D0010A on LangLearn_LLWordPair (wordFromId, wordToId);