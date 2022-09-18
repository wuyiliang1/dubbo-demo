package com.scaffold.test;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class UrlTest {

    public static final String REGEX = "(([a-z]+://)?(([a-z0-9\\-]+\\.)+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel|local|internal))(:[0-9]{1,5})?(/[a-z0-9_\\-.~]+)*(/([a-z0-9_\\-.]*)(\\?[a-z0-9+_\\-.%=&amp;]*)?)?(#[a-zA-Z0-9!$&'()*+.=-_~:@/?]*)?)(\\s+|$)";

    @Test
    public void testExtractUrl() {
        Assert.assertEquals(expected, extractUrl(input));
    }

    public String extractUrl(String text) {
        return text.replaceAll(REGEX, "<a href=\"$1\">$1</a>");
    }

    @Parameterized.Parameter(0)
    public String input;

    @Parameterized.Parameter(1)
    public String expected;

    @Parameterized.Parameters
    public static List<String[]> testData() {
        InputStream inputStream = ResourceUtil.getStream("url_extract_test_data.txt");
        List<String> fileData = IoUtil.readUtf8Lines(inputStream, new ArrayList<>());
        List<String[]> testData = new ArrayList<>();
        for (int i = 0; i < fileData.size() / 3; i++) {
            testData.add(new String[] {fileData.get(3 * i), fileData.get(3 * i + 1)});
        }
        return testData;
    }
}
