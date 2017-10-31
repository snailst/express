package com.snailst.express.web.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuzhongpei
 * @date 2017/10/31 16:08
 * @description
 * @since 1.0
 */
public class ExpressCodeDto {

    private String com;

    private long start;

    private long end;

    public String getCom() {
        return com;
    }

    public void setCom(String com) {
        this.com = com;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public List<String> getCodes() {
        List<String> codes = new ArrayList<>();
        for (long i = start; i <= end; i++) {
            codes.add(String.valueOf(i));
        }
        return codes;
    }

    @Override
    public String toString() {
        return "ExpressCodeDto{" +
                "com='" + com + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
