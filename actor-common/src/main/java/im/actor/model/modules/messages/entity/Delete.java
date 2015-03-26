package im.actor.model.modules.messages.entity;

import java.io.IOException;
import java.util.List;

import im.actor.model.droidkit.bser.BserObject;
import im.actor.model.droidkit.bser.BserValues;
import im.actor.model.droidkit.bser.BserWriter;
import im.actor.model.entity.Peer;

/**
 * Created by ex3ndr on 26.03.15.
 */
public class Delete extends BserObject {

    private Peer peer;
    private List<Long> rids;

    public Delete(Peer peer, List<Long> rids) {
        this.peer = peer;
        this.rids = rids;
    }

    public Delete() {

    }

    public Peer getPeer() {
        return peer;
    }

    public List<Long> getRids() {
        return rids;
    }

    @Override
    public void parse(BserValues values) throws IOException {
        peer = Peer.fromBytes(values.getBytes(1));
        rids = values.getRepeatedLong(2);
    }

    @Override
    public void serialize(BserWriter writer) throws IOException {
        writer.writeObject(1, peer);
        writer.writeRepeatedLong(2, rids);
    }
}
