import SwiftUI

@main
struct iOSApp: App {
	@StateObject var navigation = Navigation()
	
	init() {
		Koin.start()
	}
	
	var body: some Scene {
		WindowGroup {
			if #available(iOS 16.0, *) {
				NavigationStack(path: $navigation.paths) {
					LoginScreen()
						.navigationDestination(for: String.self) { path in
							switch path {
								case Paths.home:
									HomeScreen()
								default:
									LoginScreen()
							}
						}
				}
				.environmentObject(navigation)
			} else {
				// TODO: Fallback on earlier versions
				LoginScreen()
			}
		}
	}
}
