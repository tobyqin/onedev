package gitplex.product;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.pmease.gitplex.web.page.repository.commit.CommitQueryLexer;
import com.pmease.gitplex.web.page.repository.commit.CommitQueryParser;

public class Test {

	@org.junit.Test
	public void test() throws IOException {
		CommitQueryLexer lexer = new CommitQueryLexer(new ANTLRInputStream("rule1"));
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		CommitQueryParser parser = new CommitQueryParser(tokens);
		lexer.removeErrorListeners();
		parser.removeErrorListeners();
		parser.addErrorListener(new BaseErrorListener() {

			@Override
			public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line,
					int charPositionInLine, String msg, RecognitionException e) {
				Parser parser = (Parser) recognizer;
				System.out.println(parser.getRuleContext());
			}
			
		});
		parser.test();
	}
	
}