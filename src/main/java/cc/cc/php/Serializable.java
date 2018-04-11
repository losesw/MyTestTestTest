/**
 * @Version 1.0.0
 * Copyright (c) 2016上海相诚金融-版权所有
 */
package cc.cc.php;

/** Serializable.java
*
* Author:       Ma Bingyao <andot@ujn.edu.cn>
* Copyright:    CoolCode.CN
* Version:      2.1
* LastModified: 2006-08-09
* This library is free.  You can redistribute it and/or modify it.
* http://www.coolcode.cn/?p=202
*/
interface Serializable {
    byte[] serialize();
    void unserialize(byte[] ss);
}
