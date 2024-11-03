package de.eztxm.core.listener;

import de.eztxm.core.AutoChatAddon;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.server.ServerJoinEvent;
import net.labymod.api.util.concurrent.task.Task;
import java.util.concurrent.TimeUnit;

public class ServerListener {

  private final AutoChatAddon addon;

  public ServerListener(AutoChatAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onJoin(ServerJoinEvent event) {
    if (this.addon.configuration().server().get().equalsIgnoreCase("")) return;
    if (!event.serverData().address().getHost().equalsIgnoreCase(this.addon.configuration().server().get())) return;
    Task.builder(() -> {
      this.addon.labyAPI().minecraft().chatExecutor().chat(this.addon.configuration().input().get(), false);
    }).delay(1, TimeUnit.SECONDS).build().executeOnRenderThread();
  }
}
