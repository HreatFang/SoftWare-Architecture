package org.csu.mypetstore.persistence;

import org.csu.mypetstore.domain.Sequence;

public interface SequenceMapper {

    // 得到序列
    Sequence getSequence(Sequence sequence);

    // 更新序列
    boolean updateSequence(Sequence sequence);
}
