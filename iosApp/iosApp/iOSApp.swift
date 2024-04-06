import SwiftUI
import shared

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
						.navigationDestination(for: Item.self) { item in
							ItemScreen(item: item)
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
