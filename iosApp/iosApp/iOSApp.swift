//
//  iOSApp.swift
//  iosApp
//
//  Created by timur.pehlivan on 05/09/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

@main
struct iOSApp: App {
    init() { AppModuleKt.doInitKoin() }
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}