package com.example.kdh.util;

import lombok.Data;

@Data
public class Pager {

    private long totalRecord;

    private int pageScale; // 페이지당 최대 게시물 수
    private int blockScale; // 화면당 최대 페이지 수

    private int totalPage;
    private int curPage;

    private int blockBegin;
    private int blockEnd;

    public Pager(long totalRecord, int curPage) {
        this(totalRecord, curPage, 10);
    }

    public Pager(long totalRecord, int curPage, int pageScale) {
        this(totalRecord, curPage, pageScale, 10);
    }

    public Pager(long totalRecord, int curPage, int pageScale, int blockScale) {
        this.totalRecord = totalRecord;
        this.pageScale = pageScale;
        this.blockScale = blockScale;
        this.curPage = curPage;

        init(totalRecord);
    }

    private void init(long totalRecord) {
        totalPage = totalRecord % pageScale == 0 ?
                (int) (totalRecord / pageScale) :
                (int) (totalRecord / pageScale) + 1;

        if (totalPage < 1) totalPage = 1;

        if (getTotalPage() == 1) {
            blockBegin = 1;
            blockEnd = 1;
        }

        if (getTotalPage() <= getBlockScale()) {
            blockBegin = 1;
            blockEnd = getTotalPage();

            return;
        }

        int rightCount = blockScale - (getCurPage() % 10);
        int leftCount = blockScale - (rightCount + 1);

        if (getCurPage() % 10 == 0) {
            blockBegin = Math.max(1, getCurPage() - 9);
            blockEnd = Math.min(getCurPage(), getTotalPage());

        } else {
            blockBegin = Math.max(1, getCurPage() - leftCount);
            blockEnd = Math.min((getCurPage() + rightCount), getTotalPage());
        }
    }

    public int getBlockBeginForFront() {
        int blockScale = (curPage / 10);
        blockBegin = blockScale * 10 + 1;
        return blockBegin;
    }

    public int getBlockEndForFront() {
        int blockScale = (curPage / 10);
        blockEnd = Math.min(totalPage, (blockScale + 1) * 10);
        return blockEnd;
    }

    public boolean isActiveLeftArrow() {
        return curPage != 1;
    }

    public boolean isActiveRightArrow() {
        return curPage != totalPage;
    }

    public long pageOffset() {
        return getTotalRecord() - ((long) (getCurPage() - 1) * getPageScale());
    }

    public DataMessage toMessage() {
        return new DataMessage()
                .addData("hasPrev", isActiveLeftArrow())
                .addData("hasNext", isActiveRightArrow())
                .addData("totalElement", totalRecord)
                .addData("blockStart", getBlockBeginForFront())
                .addData("blockEnd", getBlockEndForFront())
                .addData("curPage", curPage)
                .addData("pageOffset", pageOffset());
    }

}
