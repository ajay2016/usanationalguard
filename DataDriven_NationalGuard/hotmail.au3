$windowHandle=WinGetHandle("Hotmail")
WinActivate($windowHandle)

ControlGetText("Hotmail","","[CLASS:ApplicationFrameInputSinkWindow; INSTANCE:1]")

