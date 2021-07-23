package com.example.algorithm;

public class quickLinkList {

//    struct ziplist<T> {  默认每个的长度是 8K
//        int32 zlbytes; // 整个压缩列表占用字节数
//        int32 zltail_offset; // 最后一个元素距离压缩列表起始位置的偏移量，用于快速定位到最后一个节点
//        int16 zllength; // 元素个数
//        T[] entries; // 元素内容列表，挨个挨个紧凑存储
//        int8 zlend; // 标志压缩列表的结束，值恒为 0xFF
//    }
//
//    struct entry {
//        int<var> prevlen; // 前一个 entry 的字节长度 快速定位前一个元素的 内存起始位置
//        int<var> encoding; // 元素类型编码
//        optional byte[] content; // 元素内容
//    }


//    struct ziplist_compressed {
//        int32 size;
//        byte[] compressed_data;
//    }
//    struct quicklistNode {
//        quicklistNode* prev;
//        quicklistNode* next;
//        ziplist* zl; // 指向压缩列表
//        int32 size; // ziplist 的字节总数
//        int16 count; // ziplist 中的元素数量
//        int2 encoding; // 存储形式 2bit，原生字节数组还是 LZF 压缩存储
//    ...
//    }
//    struct quicklist {
//        quicklistNode* head;
//        quicklistNode* tail;
//        long count; // 元素总数
//        int nodes; // ziplist 节点的个数
//        int compressDepth; // LZF 算法压缩深度
//    ...
//    }



//    每个 ziplist 存多少元素？
//    quicklist 内部默认单个 ziplist 长度为 8k 字节，超出了这个字节数，就会新起一个 ziplist。ziplist 的长度由配置参数list-max-ziplist-size决定。
//
//            # Lists are also encoded in a special way to save a lot of space.
//            # The number of entries allowed per internal list node can be specified
//# as a fixed maximum size or a maximum number of elements.
//# For a fixed maximum size, use -5 through -1, meaning:
//            # -5: max size: 64 Kb  <-- not recommended for normal workloads
//# -4: max size: 32 Kb  <-- not recommended
//# -3: max size: 16 Kb  <-- probably not recommended
//# -2: max size: 8 Kb   <-- good
//# -1: max size: 4 Kb   <-- good
//# Positive numbers mean store up to _exactly_ that number of elements
//# per list node.
//# The highest performing option is usually -2 (8 Kb size) or -1 (4 Kb size),
//            # but if your use case is unique, adjust the settings as necessary.
//    list-max-ziplist-size -2


//    quicklist 默认的压缩深度是 0，也就是不压缩。压缩的实际深度由配置参数list-compress-depth决定。
//    为了支持快速的 push/pop 操作，quicklist 的首尾两个 ziplist 不压缩，此时深度就是 1。
//    如果深度为 2，就表示 quicklist 的首尾第一个 ziplist 以及首尾第二个 ziplist 都不压缩。
}
