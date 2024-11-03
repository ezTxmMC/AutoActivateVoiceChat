package de.eztxm.core;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import de.eztxm.core.listener.ServerListener;

@AddonMain
public class AutoChatAddon extends LabyAddon<AutoChatConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.registerListener(new ServerListener(this));

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<AutoChatConfiguration> configurationClass() {
    return AutoChatConfiguration.class;
  }
}
