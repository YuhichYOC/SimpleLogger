/*
 *
 * SimpleLogger.java
 *
 * Copyright 2019 Yuichi Yoshii
 *     吉井雄一 @ 吉井産業  you.65535.kir@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.yoclabo.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SimpleLogger {

    public static void error(String message) {
        Logger l = LogManager.getLogger("ErrorLog");
        l.error(message);
    }

    public static void error(String message, Exception e) {
        message += joinStackTrace(e);
        error(message);
    }

    public static void warn(String message) {
        Logger l = LogManager.getLogger("WarnLog");
        l.warn(message);
    }

    public static void warn(String message, Exception e) {
        message += joinStackTrace(e);
        warn(message);
    }

    public static void info(String message) {
        Logger l = LogManager.getLogger("InfoLog");
        l.info(message);
    }

    public static void info(String message, Exception e) {
        message += joinStackTrace(e);
        info(message);
    }

    private static String joinStackTrace(Exception e) {
        String ret = "\n" + e.getMessage() + "\n";
        ret += Arrays.stream(e.getStackTrace()).map(s -> {
            return "\t class ... " + s.getClassName() + "\t method ... " + s.getMethodName() + "\t line ... " + s.getLineNumber();
        }).collect(Collectors.joining("\n"));
        return ret;
    }
}
