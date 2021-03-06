import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Driver {
	public static void main(String[] args) throws IOException {
		String returnS;
		LittleLexer lexer = new LittleLexer(CharStreams.fromFileName(args[0]));
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		LittleParser parser = new LittleParser(tokenStream);
		ParseTreeWalker walker = new ParseTreeWalker();
		LittleBaseListener listener = new LittleBaseListener();
		walker.walk(listener, parser.program());
		if(parser.getNumberOfSyntaxErrors() > 0)
		{
			returnS = "Not Accepted";
		}
		else{
			returnS = "Accepted";
		}
		System.out.println(returnS);
	}
}      