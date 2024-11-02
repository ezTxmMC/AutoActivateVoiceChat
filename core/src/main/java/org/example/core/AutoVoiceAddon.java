package org.example.core;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;
import org.example.core.listener.ServerListener;

@AddonMain
public class AutoVoiceAddon extends LabyAddon<AutoVoiceConfiguration> {

  @Override
  protected void enable() {
    this.registerSettingCategory();

    this.registerListener(new ServerListener(this));

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<AutoVoiceConfiguration> configurationClass() {
    return AutoVoiceConfiguration.class;
  }
}
