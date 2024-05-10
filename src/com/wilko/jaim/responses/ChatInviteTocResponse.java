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
 * BuddyUpdateTocResponse.java
 *
 * Created on 5 May 2002, 21:19
 */

package com.wilko.jaim.responses;

import com.wilko.jaim.JaimEventListener;

import java.util.StringTokenizer;

/**
 * A BuddyUpdateTocResponse is delivered to a {@link JaimEventListener } when a buddy update is received from the TOC server
 *
 * @author paulw
 * @version $Revision: 1.7 $
 */
public class ChatInviteTocResponse extends TocResponse implements TocResponseHandler {

    public static String RESPONSE_TYPE = "CHAT_INVITE";
    private String roomName;
    private String roomID;
    private String senderScreenname;
    private String message;

    /**
     * Creates new BuddyUpdateTocResponse
     */
    public ChatInviteTocResponse() {
        roomName = "";
        roomID = "";
        senderScreenname = "";
        message = "";
    }

    /**
     * The parseString method is used to populate the fields of this class from a Buddy Update string from the TOC server
     *
     * @param str The String containing the buddy update
     */
    public TocResponse parseString(String str) {
        ChatInviteTocResponse tr = new ChatInviteTocResponse();
        tr.doParse(str);
        return (tr);
    }

    private void doParse(String str) {
        cmd = str;
        StringTokenizer st = new StringTokenizer(str, ":");

        st.nextToken();
        roomName = st.nextToken();
        roomID = st.nextToken();
        senderScreenname = st.nextToken();
        message = st.nextToken();
    }

    /**
     * Get the response type of  this response.  This method is used by the response dispatcher within JaimConnection
     *
     * @return The response type
     */
    public String getResponseType() {
        return RESPONSE_TYPE;
    }

    public String getRoomName() {
        return roomName;
    }

    public String getRoomID() {
        return roomID;
    }

    public String getSenderScreenname() {
        return senderScreenname;
    }

    public String getMessage() {
        return message;
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
