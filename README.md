# GodModeSystem

## Beschreibung

GodModeSystem ist ein Minecraft-Plugin, das es Spielern ermöglicht, den GodMode-Modus auf einfache Weise zu aktivieren und zu deaktivieren. Mit diesem Plugin können Spieler ihren eigenen GodMode aktivieren oder den GodMode für andere Spieler verwalten, wenn sie über die entsprechenden Berechtigungen verfügen.

## Funktionen

- **Eigenen GodMode aktivieren/deaktivieren:** Spieler können ihren eigenen GodMode mit dem Befehl `/godmode` aktivieren oder deaktivieren.
- **GodMode für andere Spieler:** Spieler mit der entsprechenden Berechtigung können den GodMode für andere Spieler aktivieren oder deaktivieren.
- **Anpassbare Nachrichten:** Alle Nachrichten, die an Spieler gesendet werden, können in der `config.yml` angepasst werden.

## Installation

1. **Lade das Plugin herunter:** Gehe zu den [Releases](https://github.com/ItsUhr/godmodesystem) und lade die neueste Version des Plugins herunter.
2. **Plugin in den Plugins-Ordner verschieben:** Verschiebe die heruntergeladene `.jar`-Datei in den `plugins`-Ordner deines Minecraft-Servers.
3. **Server neu starten:** Starte deinen Minecraft-Server neu, um das Plugin zu laden.

## Konfiguration

Nach dem ersten Start des Servers wird eine `config.yml` im `plugins/GodModeSystem`-Ordner erstellt. Diese Datei enthält alle einstellbaren Nachrichten und Berechtigungen.

Beispiel `config.yml`:

```yaml
# =============================================
#          GodModeSystem - Config.yml
# =============================================
messages:
  no_permission: "&cDu hast keine &4Berechtigung&c, dies zu tun!"
  not_a_player: "&cDu musst ein Spieler sein!"
  wrong_usage: "&cBitte nutze &e/godmode &8<&b&lSpielerName&8>"
  player_not_found: "&cDer Spieler &b&l%target% &cist nicht vorhanden!"
  godmode_enabled_self: "&7Du hast dein &e&lGodMode &a&lAktiviert&7."
  godmode_disabled_self: "&7Du hast dein &e&lGodMode &c&lDeaktiviert&7."
  godmode_enabled_other: "&7Du hast &b&l%target% &e&lGodmode &a&lAktiviert&7."
  godmode_disabled_other: "&7Du hast &b&l%target% &e&lGodmode &c&lDeaktiviert&7."
  target_godmode_enabled: "&7Dein &e&lGodMode &7wurde &a&lAktiviert&7."
  target_godmode_disabled: "&7Dein &e&lGodMode &7wurde &c&lDeaktiviert&7."
permissions:
  use_godmode: "godmodesystem.command.godmode"
