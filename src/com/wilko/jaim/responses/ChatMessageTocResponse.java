/*
 *   (C) 2002 Paul Wilkinson  wilko@users.sourceforge.net
 *
 *   This program is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   This program is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with this program; if not, write to the Free Software
 *   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

/*
 * TocIMResponse.java
 *
 * Created on 4 May 2002, 14:38
 */

package com.wilko.jaim.responses;

import com.wilko.jaim.JaimEventListener;
import com.wilko.jaim.Utils;

import java.util.Objects;
import java.util.StringTokenizer;

/**
 * This response is delivered to a {@link JaimEventListener } when an instant message is received
 *
 * @author paulw
 * @version $Revision: 1.6 $
 */
public class ChatMessageTocResponse extends TocResponse implements TocResponseHandler {

    public static final String RESPONSE_TYPE = "CHAT_IN";
    String roomID;
    String screenname;
    Boolean whisper;
    String message;

    /**
     * Creates new TocIMResponse
     */
    public ChatMessageTocResponse() {
        roomID = "";
        screenname = "";
        whisper = false;
        message = "";
    }

    public String getRoomID() {
        return (roomID);
    }

    public String getScreenname() {
        return (screenname);
    }

    public Boolean getWhisper() {
        return whisper;
    }


    /**
     * Obtain the message
     *
     * @return The message
     * @see Utils#stripHTML
     */
    public String getMessage() {
        return (message);
    }

    /**
     * Parse an incoming IM response string
     *
     * @param str The string to be parsed
     */
    public TocResponse parseString(String str) {
        ChatMessageTocResponse tr = new ChatMessageTocResponse();
        tr.doParse(str);
        return (tr);
    }

    private void doParse(String str) {
        cmd = str;
        StringTokenizer st = new StringTokenizer(str, ":");

        st.nextToken();
        roomID = st.nextToken();
        screenname = st.nextToken();
        whisper = (Objects.equals(st.nextToken(), "T"));
        message = st.nextToken();
    }

    /**
     * Obtain the response type for response dispatching purposes
     *
     * @return The response type
     */
    public String getResponseType() {
        return (RESPONSE_TYPE);
    }

    /**
     * Returns true if this response handler can handle the specified response.
     *
     * @param Response - the response string from TOC.  This is the part of the response before the first ':'
     * @return true if the response can be handled
     */
    public boolean canHandle(String Response) {
        return (Response.equalsIgnoreCase(RESPONSE_TYPE));
    }

}
