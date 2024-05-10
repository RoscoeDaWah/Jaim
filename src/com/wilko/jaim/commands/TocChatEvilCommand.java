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
 * TocIMCommand.java
 *
 * Created on 4 May 2002, 15:18
 */

package com.wilko.jaim.commands;

/**
 * @author paulw
 * @version $Revision: 1.4 $
 */
public class TocChatEvilCommand extends TocCommand {

    private final String roomID;
    private final String screenname;
    private final Boolean anonymous;

    /**
     * Creates new TocIMCommand
     */
    public TocChatEvilCommand(String roomID, String screenname, Boolean anonymous) {
        this.roomID = roomID;
        this.screenname = screenname;
        this.anonymous = anonymous;
    }

    public String toString() {
        return ("toc_chat_evil " + roomID + " " + screenname + " " + (anonymous ? "anon" : "norm"));
    }

    public byte[] getBytes() {
        return (this.toString().getBytes());
    }

}
