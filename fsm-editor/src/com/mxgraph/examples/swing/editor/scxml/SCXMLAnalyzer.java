package com.mxgraph.examples.swing.editor.scxml;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.util.CharTokenizer;

public final class SCXMLAnalyzer extends Analyzer {

	Pattern p = Pattern.compile("[a-zA-Z0-9]");

	@Override
	protected TokenStreamComponents createComponents(String fieldName) {

		return new TokenStreamComponents(new CharTokenizer() {

			@Override
			protected boolean isTokenChar(int c) {
				String s = "" + c;
				Matcher m = p.matcher(s);
				return m.matches();
			}
		});

	}

}
