package zepsizola.me.velocityafkkick;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.player.KickedFromServerEvent;
import com.velocitypowered.api.proxy.Player;
import com.velocitypowered.api.proxy.ProxyServer;
import net.kyori.adventure.text.Component;
import org.slf4j.Logger;

public class VelocityAFKKick {

    @Inject
    private Logger logger;

    @Inject
    private ProxyServer server;

    private Config config;

    @Subscribe
    public void onProxyInitialization() {
        config = new Config();
    }

    @Subscribe
    public void onPlayerKicked(KickedFromServerEvent event) {
        Player player = event.getPlayer();
        String kickReason = event.getServerKickReason().map(Component::toString).orElse("");

        // Check if the kick reason contains certain words
        if (kickReason.contains(config.getKickWords())) {
            // Disconnect the player from the proxy
            player.disconnect(Component.text(config.getKickMessage()));
        }
    }
}