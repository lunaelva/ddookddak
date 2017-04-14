INSERT INTO boards VALUES (1, '{"boardType" : "1", "pageLimit":"10","reportUse":"Y","boardKorName":"자유","imageAddUse":"Y","boardId":0,"commentMaxCnt":"5","recommUse":"Y","mediaAddUse":"Y" ,"commentUse":"Y"}','free');
INSERT INTO boards VALUES (2, '{"boardType" : "2", "pageLimit":"16","reportUse":"Y","boardKorName":"이미지","imageAddUse":"Y","boardId":0,"commentMaxCnt":"5","recommUse":"Y","mediaAddUse":"Y","commentUse":"Y"}','image');

INSERT INTO board_category(category_id,board_id,cate_name,sort, hidden)values(1, 1, '자유', 1, 'N');
INSERT INTO board_category(category_id,board_id,cate_name,sort, hidden)values(2, 1, '인증', 2, 'N');
INSERT INTO board_category(category_id,board_id,cate_name,sort, hidden)values(3, 2, '팬아트', 1, 'N');
INSERT INTO board_category(category_id,board_id,cate_name,sort, hidden)values(4, 2, '웹툰', 2, 'N');