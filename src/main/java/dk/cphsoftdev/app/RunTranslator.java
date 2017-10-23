package dk.cphsoftdev.app;

import dk.cphsoftdev.app.controller.ReceiveController;
import dk.cphsoftdev.app.controller.SenderController;

public class RunTranslator
{
    public static void main( String[] args )
    {
        ReceiveController receive = new ReceiveController( "group3.bank.normalizator" );
        SenderController sender = new SenderController( "group3.bankMQ", "", "group3.bank.normalizator" );

        sender.sendMessage( "1209855372,500,12000.0,48" );
        receive.printMessages();

        sender.close();
        receive.close();

        // Start Translator (On production use this)
        // -----------------------------------------------------------------------------------------------
/*        ReceiveController receive = new ReceiveController( "group3.reciplist.xmltranslator" );
        SenderController sender = new SenderController( "group3.bankMQ", "", "group3.bank.normalizator" );

        for( String message : receive.getMessages() )
        {
            sender.sendMessage( message );
        }

        sender.close();
        receive.close();*/
    }
}
