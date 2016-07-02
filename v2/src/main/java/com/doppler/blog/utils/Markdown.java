package com.doppler.blog.utils;


import com.doppler.blog.web.MarkdownService;
import com.doppler.blog.web.PegDownMarkdownService;

/**
 * A Markdown processing util class
 */
public class Markdown {

    private static final MarkdownService MARKDOWN_SERVICE = new PegDownMarkdownService();

    public static String markdownToHtml(String content){
        return MARKDOWN_SERVICE.renderToHtml(content);
    }
}
