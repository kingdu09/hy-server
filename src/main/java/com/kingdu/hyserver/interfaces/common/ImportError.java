package com.kingdu.hyserver.interfaces.common;

/**
 * 导入失败明细：row 为提交列表中的 1 基序号。
 */
public record ImportError(int row, String reason) {
}
