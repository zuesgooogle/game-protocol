package com.simplegame.protocol.encrypt;

/**
 * @author zeusgooogle
 * @date 2015-05-03 下午04:08:40
 */
public class SimpleEncrypt {

    private String ticket;

    private byte[] ticketBytes;

    private int ticketLength;

    private int ticketIndex = 0;

    private int deTicketIndex = 0;

    private String key;

    private byte[] keyBytes;

    private int keyLength;

    private int keyIndex;

    private int deKeyIndex;

    public SimpleEncrypt(String key, String ticket) {
        if ((null == key) || ("".equals(key))) {
            throw new RuntimeException("key must be not null or empty.");
        }
        
        if ((null == ticket) || ("".equals(ticket))) {
            throw new RuntimeException("ticket must be not null or empty.");
        }
        
        this.ticket = ticket;
        this.ticketBytes = this.ticket.getBytes();
        this.ticketLength = this.ticketBytes.length;
        this.ticketIndex = 0;
        this.deTicketIndex = 0;
        this.key = key;
        this.keyBytes = this.key.getBytes();
        this.keyLength = this.keyBytes.length;
        this.keyIndex = 0;
        this.deKeyIndex = 0;
    }

    public byte[] encode(byte[] bytes) {
        int i = bytes.length;
        for (int j = 0; j < i; j++) {
            int k = this.ticketBytes[this.ticketIndex];
            this.ticketIndex = (++this.ticketIndex % this.ticketLength);
            int m = this.keyBytes[this.keyIndex];
            this.keyIndex = (++this.keyIndex % this.keyLength);
            bytes[j] = ((byte) (bytes[j] + k - m));
        }
        return bytes;
    }

    public byte[] decode(byte[] bytes) {
        int i = bytes.length;
        for (int j = 0; j < i; j++) {
            int k = this.ticketBytes[this.deTicketIndex];
            this.deTicketIndex = (++this.deTicketIndex % this.ticketLength);
            int m = this.keyBytes[this.deKeyIndex];
            this.deKeyIndex = (++this.deKeyIndex % this.keyLength);
            bytes[j] = ((byte) (bytes[j] - k + m));
        }
        return bytes;
    }

    public static String getKey() {
        return "[ZZZZZZ-EEEE-UUUU-SSSSSS]";
    }

}
