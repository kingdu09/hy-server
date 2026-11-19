package com.kingdu.hyserver.interfaces.common;

import java.util.List;

/**
 * 批量导入结果：total 为提交行数，success/failed 为成功与失败数。
 */
public record ImportResult(int total, int success, int failed, List<ImportError> errors) {
}
