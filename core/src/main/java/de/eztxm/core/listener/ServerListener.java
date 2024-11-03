package de.eztxm.core.listener;

import de.eztxm.core.AutoVoiceAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.ServerJoinEvent;

public class ServerListener {

  private final AutoVoiceAddon addon;

  public ServerListener(AutoVoiceAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onJoin(ServerJoinEvent event) throws InterruptedException {
    if (this.addon.configuration().server().get().equalsIgnoreCase("")) return;
    if (!event.serverData().address().getHost().equalsIgnoreCase(this.addon.configuration().server().get())) return;
    this.addon.labyAPI().wait(2500);
    this.addon.labyAPI().minecraft().chatExecutor().chat("/labymod voicechat activate");
  }
}
