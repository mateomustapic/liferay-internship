create index IX_FB6BD9C3 on Music_Album (bendId);

create index IX_86616C01 on Music_Bend (bendId);
create unique index IX_A61C2358 on Music_Bend (name);

create index IX_2FD88681 on Music_Event (artist);
create index IX_AAD4E27F on Music_Event (eventId);

create index IX_E283D05 on Music_Song (albumId);