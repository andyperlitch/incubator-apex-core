/**
 * Copyright (C) 2015 DataTorrent, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.datatorrent.bufferserver.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


/**
 *
 */
public class CodecTest
{
  @Test
  public void testSomeMethod()
  {
    byte buffer[] = new byte[10];
    int value = 127;
    VarInt.write(value, buffer, 0);

    SerializedData sd = new SerializedData(buffer, 0, 0);
    VarInt.read(sd);
    assertEquals(sd.length - sd.dataOffset, value);

    VarInt.write(value, buffer, 0, 5);
    sd.length = 0;
    sd.dataOffset = 0;
    VarInt.read(sd);
    assertEquals(sd.length - sd.dataOffset, value);
  }

  private static final Logger logger = LoggerFactory.getLogger(CodecTest.class);
}
