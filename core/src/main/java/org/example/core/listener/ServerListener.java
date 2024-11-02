package org.example.core.listener;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.ServerLoginEvent;
import org.example.core.AutoVoiceAddon;

public class ServerListener {

  private final AutoVoiceAddon addon;

  public ServerListener(AutoVoiceAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onLogin(ServerLoginEvent event) {
    if (this.addon.configuration().server().get().equalsIgnoreCase("")) return;
    if (!event.serverData().address().getHost().equalsIgnoreCase(this.addon.configuration().server().get())) return;
    this.addon.sendMessage("/labymod voicechat activate");
  }
}
