package de.eztxm.core.listener;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.ServerLoginEvent;
import de.eztxm.core.AutoVoiceAddon;

public class ServerListener {

  private final AutoVoiceAddon addon;

  public ServerListener(AutoVoiceAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onLogin(ServerLoginEvent event) {
    this.addon.displayMessage(this.addon.configuration().server().get());
    if (this.addon.configuration().server().get().equalsIgnoreCase("")) return;
    if (!event.serverData().address().getHost().equalsIgnoreCase(this.addon.configuration().server().get())) return;
    this.addon.labyAPI().minecraft().chatExecutor().chat("/labymod voicechat activate");
  }
}
